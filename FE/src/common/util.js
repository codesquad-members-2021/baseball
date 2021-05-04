export const divideArray = (arrData, refNum = 2) => {
    const result = [];
    const arrTmp = [...arrData];

    const cnt = Math.floor(arrData.length / refNum);
    for (let i = 0; i < cnt; i++)
        result.push(arrTmp.splice(0, refNum));

    return result;
};
