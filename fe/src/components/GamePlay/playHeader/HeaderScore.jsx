import { useContext } from 'react'
import {gamePlayContext} from 'pages/Game'
import styled from 'styled-components'
import Span from 'components/Span'
import FlexCenter from 'styles/FlexCenter'


const HeaderScore = () => {
    const {home, away} = useContext(gamePlayContext);

    return (
        <div>
            <span>Captain</span>
            <span>1</span>
            <span>vs</span>
            <span>5</span>
            <span>Mavel</span>
        </div>
    )
}

export default HeaderScore

const 