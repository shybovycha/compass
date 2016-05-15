import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory } from 'react-router';
import injectTapEventPlugin from 'react-tap-event-plugin';

import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import HomePage from './HomePage';

import OrganizationList from './OrganizationList';
import CourseList from './CourseList';
import QuestionList from './QuestionList';

import OrganizationPage from './OrganizationPage';
import CoursePage from './CoursePage';
import QuestionPage from './QuestionPage';

import SidebarMenu from './SidebarMenu';

import Stub from './Stub';

const App = React.createClass({
    getInitialState: function () {
        return {
            user: Stub.user
        };
    },

    render: function () {
        return (
            <MuiThemeProvider muiTheme={ getMuiTheme() }>
                <div>
                    <SidebarMenu user={ this.state.user } title="Compass Admin" />

                    <div id="page-container" className="container">
                        <Router history={ hashHistory }>
                            <Route path="/" component={ HomePage }/>
                            <Route path="/questions" component={ QuestionList }/>
                            <Route path="/courses" component={ CourseList }/>
                            <Route path="/orgs" component={ OrganizationList }/>
                            <Route path="/question/:id" component={ QuestionPage }/>
                            <Route path="/org/:id" component={ OrganizationPage }/>
                            <Route path="/course/:id" component={ CoursePage }/>
                        </Router>
                    </div>
                </div>
            </MuiThemeProvider>
        );
    }
});

injectTapEventPlugin();

ReactDOM.render(
    <App />,
    document.getElementById('app')
);
