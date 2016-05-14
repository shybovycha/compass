import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        answers: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            showDrawer: false,
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    { this.props.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});