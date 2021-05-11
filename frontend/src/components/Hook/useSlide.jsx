import { useEffect, useState } from 'react';

const useSlide = (MouseOn) => {
	useEffect(() => {
		const handle = (event) => {
			const { clientY } = event;
			if (clientY < 5) {
				MouseOn();
				console.log('UP');
			} else if (clientY > 750) {
				MouseOn();
				console.log('Down');
			}
		};
		document.addEventListener('mousemove', handle);
		return () => {
			document.removeEventListener('mousemove', handle);
		};
	});
};

export default useSlide;
