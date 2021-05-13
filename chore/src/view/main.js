import Directory from '../components/Directory.js';
import FileNode from '../components/FileNode.js';
import ImgModal from '../components/ImgModal.js';
import PrevBtn from '../components/PrevBtn.js';

class Main {
  constructor({ model, data }) {
    this.model = model;
    this.data = data;
    this._app = document.querySelector('.App');
  }
  init() {
    this.addEvent();
    this.render(this.data);
    this.model.subscribe(this.render.bind(this));
  }
  addEvent() {
    this._app.addEventListener('click', this.handleClick.bind(this));
  }
  render(data) {
    const dataHTML = this.getHTML(data);
    this._app.innerHTML = dataHTML;
  }
  handleClick({ target }) {
    if (!target.closest('.directory') && !target.closest('.file') && !target.closest('.prevBtn'))
      return;
    if (target.closest('.directory')?.classList.contains('directory')) {
      this.handleDirClick(target.closest('.directory').dataset.id);
    } else if (target.closest('.file')?.classList.contains('file')) {
      console.log('file');
      console.log(target.closest('.file').dataset.filepath);
      this.handleFileClick(target.closest('.file').dataset.filepath);
    } else if (target.closest('.prevBtn')?.classList.contains('prevBtn')) {
      console.log('prevBtn');
      this.handlePrevBtnClick();
    }
  }
  async handleDirClick(id) {
    const res = await fetch(
      `https://zl3m4qq0l9.execute-api.ap-northeast-2.amazonaws.com/dev/${id}`
    );
    const data = await res.json();
    this.model.setData(data);
  }
  async handleFileClick(filePath) {
    new ImgModal({ filePath }).render();
  }
  handlePrevBtnClick() {
    const data = this.model.popHistory();
    this.model.setData(data);
  }
  getHTML(data) {
    let prevFlag = false;
    const prevBtn = new PrevBtn().render();
    const HTMLList = data.map((v) => {
      console.log(data);
      if (!prevFlag && v.parent) prevFlag = true;
      if (v.type === 'DIRECTORY') return new Directory(v).render();
      else if (v.type === 'FILE') return new FileNode(v).render();
    });
    console.log(HTMLList);
    if (prevFlag || HTMLList.length === 0) HTMLList.unshift(prevBtn);
    return HTMLList.join('');
  }
}

export default Main;
