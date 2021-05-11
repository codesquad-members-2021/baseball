const delay = (fn, delay) =>
	new Promise((res, rej) => {
		fn();
		setTimeout(() => res(), delay);
	});

export default delay;
