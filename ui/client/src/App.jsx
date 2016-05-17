import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory } from 'react-router';
import injectTapEventPlugin from 'react-tap-event-plugin';

import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import HomePage from './HomePage';
import Questionnaire from './Questionnaire';
import SearchDashboard from './SearchDashboard';
import Search from './Search';
import AccountPage from './AccountPage';
import OrganizationPage from './OrganizationPage';
import CoursePage from './CoursePage';

import SidebarMenu from './SidebarMenu';

import DataSourceLoader from './DataSource';
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
                    <SidebarMenu user={ this.state.user } title="Compass" />

                    <div id="page-container" className="container">
                        <Router history={ hashHistory }>
                            <Route path="/" component={ HomePage }/>
                            <Route path="/account" component={ AccountPage }/>
                            <Route path="/questionnaire" component={ Questionnaire }/>
                            <Route path="/searches" component={ SearchDashboard }/>
                            <Route path="/search/:id" component={ Search }/>
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

DataSourceLoader(function (dbData) {
    window.DataSource = dbData;

    ReactDOM.render(
        <App />,
        document.getElementById('app')
    );
});