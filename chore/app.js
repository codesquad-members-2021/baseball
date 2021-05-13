import Model from './model/model.js';
import Main from './view/main.js';

const dataInit = async (model) => {
  const res = await fetch('https://zl3m4qq0l9.execute-api.ap-northeast-2.amazonaws.com/dev');
  const data = await res.json();
  console.log(JSON.stringify(data));
  model.setData(data);
};

const model = new Model();
new Main({ model, data: [] }).init();
dataInit(model);
