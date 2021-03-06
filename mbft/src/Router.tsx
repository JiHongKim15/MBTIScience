import React from 'react';
import { Route, Switch, Redirect } from "react-router";
import { BrowserRouter } from 'react-router-dom';

import ChatMainPage from './chat/pages/ChatMainPage';
import LoginPage from './user/pages/LoginPage';
import Home from './common/Home';
import ChatRoomListPage from './chat/pages/ChatRoomListPage';

const Router = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/chat" component={ChatMainPage} exact />
                <Route path="/chat/rooms" component={ChatRoomListPage} exact />
                <Route path="/login" component={LoginPage} exact />
                <Route component={() => <Redirect to="/" />} />
            </Switch>
        </BrowserRouter>
    );
};

export default Router;