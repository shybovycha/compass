import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import MatchedOrgs from './MatchedOrgs';
import MatchedCourses from './MatchedCourses';

import Question from './Question';
import Icon from './Icon';

// import Stub from './Stub';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            // hardcode
            questions: window.DataSource.questions,
            currentQuestion: 0,
            matchedOrgs: 0
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.state.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        this.setState({ currentQuestion: (this.state.currentQuestion + 1) % this.state.questions.length, matchedOrgs: this.state.matchedOrgs + 1 });
    },

    getSearch: function () {
        var searches = window.DataSource.searches;

        return searches[0];
    },

    render: function () {
        return (
            <div className="questionnaire container col">
                <div className="col fill-parent">
                    { this.state.matchedOrgs > 0 ? <MatchedCourses title="Matched so far" search={ this.getSearch() } /> : '' }

                    <Question {...this.getQuestion()} />
                </div>

                <div className="row bottom-button">
                    <div className="col fill-parent hcenter">
                        <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
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