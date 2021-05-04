const loadData = async (setState, type, hash) => {
	const getUrl = (type) => {
		let url = 'https://890e124d-c97a-4c91-a91a-0d19d727c1d6.mock.pstmn.io/';
		switch (type) {
			case 'mainDish':
				return (url += 'section/main');
			case 'bestDish':
				return (url += 'best');
			case 'soupDish':
				return (url += 'section/soup');
			case 'sideDish':
				return (url += 'section/side');
			case 'detailDish':
				return (url += `detail/${hash}`);
			case 'details':
				return (url += 'section/side');
			default:
				return;
		}
	};

	const response = await fetch(getUrl(type));
	const initialData = await response.json();
	const dataBody = initialData.body;
	setState(dataBody);
};

export default loadData;
