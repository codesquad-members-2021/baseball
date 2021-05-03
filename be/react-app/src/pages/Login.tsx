import React, { useState } from "react";
import Box from "@material-ui/core/Box";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  box: {
    marginBottom: theme.spacing(4),
  },
}));

export const Login = () => {
  const classes = useStyles();

  const [id, setId] = useState("");
  const [pw, setPw] = useState("");

  const handleSubmit = () => {
    alert(`id: ${id}, pw: ${pw}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <Box className={classes.box}>
        <TextField
          label="아이디"
          variant="outlined"
          value={id}
          onChange={(event) => setId(event.target.value)}
        />
      </Box>
      <Box className={classes.box}>
        <TextField
          label="비밀번호"
          variant="outlined"
          type="password"
          value={pw}
          onChange={(event) => setPw(event.target.value)}
        />
      </Box>
      <Box>
        <Button variant="contained" color="primary" type="submit">
          로그인
        </Button>
      </Box>
    </form>
  );
};
