import React from 'react';
import ReactDOM from 'react-dom';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import MyAwesomeComponent from './MyAwesomeComponent';

const App = () => (
    <MuiThemeProvider muiTheme={getMuiTheme()}>
    <MyAwesomeComponent />
    </MuiThemeProvider>
);

ReactDOM.render(
    <App />,
    document.getElementById('app')
);