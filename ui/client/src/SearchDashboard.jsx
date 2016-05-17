import React from 'react';
import { hashHistory } from 'react-router'

import RaisedButton from 'material-ui/RaisedButton';

import MatchedCourses from './MatchedCourses';

// import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            searches: window.DataSource.searches
        };
    },

    startQuestionnaire: function () {
        hashHistory.push('/questionnaire');
    },

    getDateStr: function (search) {
        var date = new Date(search.createdAt);

        return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
    },

    render: function () {
        return (
            <div className="container col">
                <div className="hcenter">
                    { this.state.searches.map(search => <MatchedCourses search={ search } title={ 'Completed on ' + this.getDateStr(search) } expanded={ true } />) }
                </div>
            </div>
        );
    }
});
