const makeDecimalPoint = (value, fix) => parseFloat(Math.round(value * (10 ^ fix)) / (10 ^ fix)).toFixed(fix);
export default makeDecimalPoint;