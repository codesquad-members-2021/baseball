export const randomPitch = () => {
  //
  const arr = ["strike", "ball", "hit"];
  return arr[Math.floor(Math.random() * arr.length)];
};

console.log(randomPitch());
console.log(randomPitch());
console.log(randomPitch());
console.log(randomPitch());
