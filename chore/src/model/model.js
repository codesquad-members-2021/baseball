class Model {
  constructor(data) {
    this._observers = new Set();
    this.data = data;
    this.history = [];
  }
  setData(newData) {
    this.history.push(newData);
    this.data = newData;
    this.notify(newData);
  }
  popHistory() {
    this.history.pop();
    return this.history.pop();
  }
  subscribe(observer) {
    this._observers.add(observer);
  }
  unsubscribe(observer) {
    this._observers = [...this._observers].filter((subscriber) => subscriber !== observer);
  }
  notify(data) {
    this._observers.forEach((observer) => observer(data));
  }
}

export default Model;
