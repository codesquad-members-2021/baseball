const randomPitch = () => {
  //
  const arr = ["strike", "ball", "anta"];
  return arr[Math.floor(Math.random() * arr.length)];
};

console.log(randomPitch());
console.log(randomPitch());
console.log(randomPitch());
console.log(randomPitch());
