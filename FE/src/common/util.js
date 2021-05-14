export const divideArray = (arrData, refNum = 2) => {
    const result = [];
    const arrTmp = [...arrData];

    const cnt = Math.floor(arrData.length / refNum);
    for (let i = 0; i < cnt; i++)
        result.push(arrTmp.splice(0, refNum));

    return result;
};

export const isAllNullObjectValues = (obj) => Object.values(obj).every((v) => !v);

export const createFetchOptions = (method, bodyData = {}) => {
    if (Object.keys(bodyData).length <= 0) return;
    const arrMethod = ['GET', 'POST', 'PUT', 'PATCH', 'DELETE'];
    const isMethod = arrMethod.findIndex((v) => method === v) > -1;
    return {
        method: isMethod ? method : 'GET',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(bodyData),
    };
}