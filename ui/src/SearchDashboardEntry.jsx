import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';

export default React.createClass({
    propTypes: {
        search: React.PropTypes.object
    },

    getInitialState: function () {
        return {};
    },

    showSearch: function () {
        hashHistory.push('/search/' + this.props.search.id);
    },

    getShowOrgHandler: function (org) {
        return function () {
            hashHistory.push('/org/' + org.id);
        }
    },

    render: function () {
        return (
            <Card className="question">
                <CardTitle subtitle={ 'Completed on ' + this.props.search.createdAt } />
                
                <CardText>
                    <div>Matched universities:</div>

                    { this.props.search.matchedOrgs.map(org => <div className="margin-top">
                            <RaisedButton
                                onClick={ this.getShowOrgHandler(org) }
                                label={ org.title }
                            />
                        </div>)
                    }
                </CardText>
                
                <CardActions>
                    <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
                            onClick={ this.showSearch }
                            label="Details"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                </CardActions>
            </Card>
        );
    }
});
