import TeamSelect from '../components/teamSelect/TeamSelect';
import MainFrame from '../components/utilComponent/MainFrame';
import Login from "../components/auth/login";

const IntroPage = () => (
    <MainFrame>
        <TeamSelect />
        <Login />
    </MainFrame>
);

export default IntroPage;