import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

import Icon from './Icon';

export default React.createClass({
    propTypes: {
        search: React.PropTypes.object,
        title: React.PropTypes.string,
        expanded: React.PropTypes.bool,
        showLink: React.PropTypes.bool,
        maxOrgs: React.PropTypes.number
    },

    getDefaultProps: function () {
        return {
            expanded: false,
            showLink: true,
            maxOrgs: 3
        };
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
            <Card className="question" expanded={ this.props.expanded }>
                { this.props.expanded ?
                    <CardHeader title={ this.props.title } /> :
                    <CardHeader title={ this.props.title } actAsExpander={ true } showExpandableButton={ true } />
                }

                <CardText expandable={ true }>
                    <div>Matched universities:</div>

                    { this.props.search.matchedOrgs.slice(0, this.state.maxOrgs).map(org => <div className="margin-top">
                            <RaisedButton
                                onClick={ this.getShowOrgHandler(org) }
                                label={ org.title }
                            />
                        </div>)
                    }
                </CardText>

                { this.props.showLink == false ? '' :
                    <CardActions expandable={ true }>
                        <RaisedButton
                            icon={ <Icon name="keyboard_arrow_right" /> }
                            onClick={ this.showSearch }
                            label="Details"
                            labelPosition="before"
                            backgroundColor="#a4c639"
                        />
                    </CardActions> }
            </Card>
        );
    }
});
