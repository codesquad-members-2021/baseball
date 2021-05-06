/*
관리되야 할 것들
1. 사용되는 폰트 사이즈
2. 사용되는 색상 (폰트색상,볼카운트색상,플레이어태그색상,현재타자색상,지난타자색상...)
*/

const FONTSIZE = {
	//16px 기준입니다.
	XS: "1rem",
	S: "1.5rem",
	M: "2rem",
	L: "2.5rem",
	XL: "3rem",
	XXL: "3.5rem"
}

const COLOR = {
	VS: "#757575",
	CURRENT_PLAYER_TAG: "#ffeeec",
	BALLCOUNT_BALL: "#51cf66",
	BALLCOUNT_STRIKE: "#fcc419",
	BALLCOUNT_OUT: "#ff6b6b",
	PLAYER_NAME: "#a5d8ff",
	PLAYER_DESCRIPTION: "#228be6",
	LOG_END_ACTION: "#1098ad",
	LOG_BALLCOUNT: "#adb5bd",
	DEFAULT: '#fff'
}

const theme = {
	FONTSIZE,
	COLOR
}

export default theme
