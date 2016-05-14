import React from 'react';

import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

import Icon from './Icon';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {};
    },

    startQuestionnaire: function () {
        hashHistory.push('/questionnaire');
    },

    save: function () {},

    render: function () {
        return (
            <div className="container col hcenter">
                <TextField floatingLabelText="User name" />

                <TextField floatingLabelText="E-mail" />

                <div className="margin-top">
                    <RaisedButton
                            icon={ <Icon name="save" /> }
                            onClick={ this.save }
                            label="Save"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                </div>
            </div>
        );
    }
});