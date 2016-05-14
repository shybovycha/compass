import React from 'react';

import Question from './Question';
import MatchedOrgs from './MatchedOrgs';

export default React.createClass({
    propTypes: {
        // search: React.PropTypes.object
    },

    getInitialState: function () {
        return {
            // hardcode here
            search: [
                { id: '1', createdAt: '2016-04-12', matchedOrgs: [ { id: '1', title: 'Munich Technological University' }, { id: '2', title: 'FHWien der WKW' }, { id: '3', title: 'EPAM Java Academy' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] },

                { id: '2', createdAt: '2016-05-07', matchedOrgs: [ { id: '4', title: 'Massachussets University Of Technology' }, { id: '5', title: 'Uniwersytet Jagielloński' }, { id: '6', title: 'Akademia Górniczo-Huthicza' }, { id: '7', title: 'University Of Cambridge' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] },

                { id: '3', createdAt: '2016-05-14', matchedOrgs: [ { id: '8', title: 'Politechnika Wrocławska' }, { id: '6', title: 'Akademia Górniczo-Huthicza'}, { id: '5', title: 'Uniwersytet Jagielloński' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] }
            ].filter(search => this.props.params.id == search.id)[0]
        };
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="col fill-parent">
                    <MatchedOrgs title={ 'Completed on ' + this.state.search.createdAt } search={ this.state.search } expanded={ true } showLink={ false } />

                    { this.state.search.answers.map(answer => <Question {...answer.question} answer={answer.answer} />) }
                </div>
            </div>
        );
    }
});