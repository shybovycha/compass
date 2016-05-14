import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            showDrawer: false,

            // hardcode here again
            currentQuestion: 0
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.props.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        this.setState({ currentQuestion: (this.state.currentQuestion + 1) % this.props.questions.length });
    },

    render: function () {
        return (
            <div className="questionnaire container col">
                <div className="col fill-parent">
                    <Question {...this.getQuestion()} />
                </div>

                <div className="row bottom-button">
                    <div className="col fill-parent hcenter">
                        <RaisedButton
                            icon={ <i className="material-icons md-36">keyboard_arrow_right</i> }
                            onClick={ this.nextQuestion }
                            label="Next question"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                    </div>
                </div>
            </div>
        );
    }
});