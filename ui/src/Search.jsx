import React from 'react';

import Question from './Question';

export default React.createClass({
    propTypes: {
        answers: React.PropTypes.array
    },

    getInitialState: function () {
        return {
            // hardcode here
            answers: [
                { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
            ]
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    { this.state.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});