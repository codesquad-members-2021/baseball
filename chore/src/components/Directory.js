class Directory {
  constructor({ id, name, type, parent }) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.parent = parent;
  }
  render() {
    return `<div class="Node directory" data-id=${this.id}>
                <img src="./assets/directory.png">
                <div>${this.name}</div>
            </div>`;
  }
}

export default Directory;
