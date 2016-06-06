import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';
import Rating from './Rating';

import qwest from 'qwest';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {};
    },

    startQuestionnaire: function () {
        qwest.post('/searches/create').then(function (_xhr, data) {
            window.localStorage.setItem('search', JSON.stringify(data));
            hashHistory.push('/questionnaire');
        });
    },

    render: function () {
        return (
            <Card className="welcome-card">
                <CardText>
                    <div className="text">
                        This application will guide you through a hard path of
                        choosing your profession in a smooth and easy way: you
                        will be asked simple questions of one- or multiple choice.
                        And then, the system will match the best universities,
                        courses or schools for you.
                    </div>
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