import React from 'react';
import ReactDOM from 'react-dom';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import Dashboard from './Dashboard';

const App = () => (
    <MuiThemeProvider muiTheme={getMuiTheme()}>
        <Dashboard title="Dashboard">
            <h1>Hello, World</h1>
        </Dashboard>
    </MuiThemeProvider>
);

ReactDOM.render(
    <App />,
    document.getElementById('app')
);