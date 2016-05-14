import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {};
    },

    startQuestionnaire: function () {
        hashHistory.push('/questionnaire');
    },

    render: function () {
        return (
            <Card>
                <CardText>
                    This application will guide you through a hard path of 
                    choosing your profession in a smooth and easy way: you
                    will be asked simple questions of one- or multiple choice.
                    And then, the system will match the best universities,
                    courses or schools for you.
                </CardText>

                <CardActions>
                    <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
                            onClick={ this.startQuestionnaire }
                            label="Start questionnaire"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                </CardActions>
            </Card>
        );
    }
});