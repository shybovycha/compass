import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string,
        questions: React.PropTypes.array
    },

    state: {
        showDrawer: true
    },

    render: function () {
        return (
            <div className="questionnaire container">
                <div className="row">
                    <div className="col fill-parent hcenter">
                        <RaisedButton
                            icon={ <i className="material-icons md-36">keyboard_arrow_up</i> }
                        />
                    </div>
                </div>

                <div className="col fill-parent">
                    { this.props.questions.map(q => <Question {...q} />) }
                </div>

                <div className="row bottom-button">
                    <div className="col fill-parent hcenter">
                        <RaisedButton
                            icon={ <i className="material-icons md-36">keyboard_arrow_down</i> }
                        />
                    </div>
                </div>
            </div>
        );
    }
});