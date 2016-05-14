import React from 'react';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Question from './Question';

import Stub from './Stub';

export default React.createClass({
    propTypes: {},

    getInitialState: function () {
        return {
            // hardcode here
            org: Stub.organizations.filter(o => o.id == this.props.params.id)[0]
        };
    },

    openOrgWebsite: function () {
        window.location.href = this.state.org.url;
    },

    render: function () {
        return (
            <div className="container">
                <Card className="organization">
                    <CardTitle title={ this.state.org.title } />

                    <CardText>
                        { this.state.org.description }
                    </CardText>

                    <CardActions>
                        <RaisedButton
                                onClick={ this.openOrgWebsite }
                                label="Website"
                                labelPosition="before"
                            />
                    </CardActions>
                </Card>
            </div>
        );
    }
});