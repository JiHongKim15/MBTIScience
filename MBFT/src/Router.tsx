import React from 'react';
import { Route, Switch, Redirect } from "react-router";
import { BrowserRouter } from 'react-router-dom';

import ChatMainPage from './pages/ChatMainPage';
import Home from './pages/Home';

const Router = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/chat" component={ChatMainPage} />
                <Route component={() => <Redirect to="/" />} />
            </Switch>
        </BrowserRouter>
    );
};

export default Router;