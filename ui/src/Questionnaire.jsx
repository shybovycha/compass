import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';
import Icon from './Icon';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            showDrawer: false,

            // hardcode
            questions: [
                { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
                { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
                { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
            ],
            currentQuestion: 0
        };
    },

    getQuestion: function () {
        // hardcode here for MVP
        return this.state.questions[this.state.currentQuestion];
    },

    nextQuestion: function () {
        this.setState({ currentQuestion: (this.state.currentQuestion + 1) % this.state.questions.length });
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