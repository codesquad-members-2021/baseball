class ImgModal {
  constructor({ filePath }) {
    this.filePath = filePath;
    this._app = document.querySelector('.App');
    this.init();
  }
  init() {
    this.addEvent();
  }
  render() {
    const imgModal = this.getHTML();
    console.log('imgModal', imgModal);
    this._app.insertAdjacentElement('beforeend', imgModal);
  }
  addEvent() {
    this._app.addEventListener('click', this.handleClick.bind(this));
  }
  handleClick({ target }) {
    if (tagName === 'IMG') return;
  }
  getHTML() {
    const modalHTML = document.createElement('div');
    modalHTML.classList.add('Modal', 'ImageViewer');
    modalHTML.innerHTML = `<div class="content">
                             <img src="https://fe-dev-matching-2021-03-serverlessdeploymentbuck-t3kpj3way537.s3.ap-northeast-2.amazonaws.com/public${this.filePath}">`;
    return modalHTML;
  }
}

export default ImgModal;
