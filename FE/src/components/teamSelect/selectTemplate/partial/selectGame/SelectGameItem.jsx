import styled, {css} from 'styled-components';
import {Link} from "react-router-dom";
import useFetch from '../../../../../hooks/useFetch';
import { useEffect, useState } from "react";

const SelectGameItem = ({ home, away, idx, to, awayBoolean, homeBoolean, setDesc}) => {
    const [boolean, setBoolean] = useState(false);
    console.log(awayBoolean,homeBoolean) // false true 나타내주는거 개발자도구창에서 보면됨.
    const options = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({"user" : home, "opponent" : away})
    }
    const fetchData = async (url) => {
        const res = await fetch(url, options);
        console.log(res);
        const result = await res.json();
        return result;
    };
    useEffect(() => {
        if(!boolean) return;
        console.log("fetch요청 갔다!")
        fetchData("/api/games/type-away");
        setBoolean(false);
    }, [boolean])
    
    const awaySelect = (e) => {
        if(awayBoolean === "true") {
            delay();
            return e.preventDefault();
        } else {
            console.log("z")
            return setBoolean(true);
        }
    }

    const homeSelect = (e) => {
        if(homeBoolean === "true") {
            delay();
            return e.preventDefault();
        } else {
            console.log("z")
            return setBoolean(true);            
        }
    }

    const delay = () =>  {
        setDesc("이미 선택된 팀입니다. 다른 팀을 선택해주세요!");
        setTimeout(() => {
            setDesc("참가할 게임을 선택하세요.")
        },2000);
    }

    return home && away && (
        <StyledSelectGameItem>
            <GameNumParagraph>Game {idx}</GameNumParagraph>
            <TeamInfo>
                <SelectGameLink to = {to} onClick={awaySelect}>
                    <TeamInfoSpan type="team" teamSelect={awayBoolean}>{away}</TeamInfoSpan> 
                </SelectGameLink>
                    <TeamInfoSpan>VS</TeamInfoSpan>
                <SelectGameLink to = {to} onClick={homeSelect}>
                    <TeamInfoSpan type="team" teamSelect={homeBoolean}>{home}</TeamInfoSpan>
                </SelectGameLink>
            </TeamInfo>
        </StyledSelectGameItem>
    );
};

export default SelectGameItem;

// --- Styled Components ---
const StyledSelectGameItem = styled.li`
    border-radius: 16px;
    padding: 12px;
    background-color: ${({ theme }) => theme.colors.gray4};
    cursor: pointer;

    & + & {
        margin-top: 20px;
    }
`;

const SelectGameLink = styled(Link)`
    text-decoration: none;
`;

const GameNumParagraph = styled.p`
    text-align: center;
    color: ${({theme}) => theme.colors.red};
    font-weight: ${({theme}) => theme.fontWeight.bold};
    font-size: ${({theme}) => theme.fontSize.L};
`;

// TeamInfo
const TeamInfo = styled.div`
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    align-items: center;
    ${GameNumParagraph} + & {
        margin-top: 20px;
    }
`;

const TeamInfoSpan = styled.span`
    font-size: ${({type, theme}) => (type === 'team') ? theme.fontSize.XXL : theme.fontSize.XL};
    font-weight: ${({type, theme}) => (type === 'team') ? theme.fontWeight.bold2 : theme.fontWeight.bold};
    color: ${({type, theme}) => (type === 'team') ? theme.colors.black1 : theme.colors.gray3};

    ${({ type }) =>
        type === 'team' &&
        css`
            &:hover {
                color: ${({ theme }) => theme.colors.red};
            }
        `};
`;