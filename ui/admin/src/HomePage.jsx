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

    showOrganizationList: function () {
        hashHistory.push('/orgs');
    },

    render: function () {
        return (
            <div>
                <div className="very-top"><div className="arrow bouncing"></div></div>

                <Card className="welcome-card">
                    <CardText>
                        <div className="text">
                            Here you can manage questions, courses and organizations.
                            <br />
                            Try opening sidebar menu and create your first organization.
                        </div>
                    </CardText>

                    <CardActions>
                        <RaisedButton label="List organizations" primary={ true } onClick={ this.showOrganizationList } />
                    </CardActions>
                </Card>
            </div>
        );
    }
});