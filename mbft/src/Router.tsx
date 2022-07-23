import React from 'react';
import { Route, Switch, Redirect } from "react-router";
import { BrowserRouter } from 'react-router-dom';

import ChatMainPage from './chat/pages/ChatMainPage';
import LoginPage from './user/pages/LoginPage';
import SingUpPage from './user/pages/SignUpPage';
import Home from './common/Home';
import ChatRoomListPage from './chat/pages/ChatRoomListPage';
import ChatRoomPage from './chat/pages/ChatRoomPage';

const Router = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/chat" component={ChatMainPage} exact />
                <Route path="/chat/rooms" component={ChatRoomListPage} exact />
                <Route path="/chat/room/:id" component={ChatRoomPage} exact />
                <Route path="/login" component={LoginPage} exact />
                <Route path="/signup" component={LoginPage} exact />
                <Route component={() => <Redirect to="/" />} />
            </Switch>
        </BrowserRouter>
    );
};

export default Router;