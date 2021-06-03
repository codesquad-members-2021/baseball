import React from "react";
import { Redirect } from "react-router-dom";
import { ROUTE_LOGIN } from "../router/const";

export const Root = () => <Redirect to={ROUTE_LOGIN} />;
