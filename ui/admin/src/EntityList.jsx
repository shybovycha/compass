import React from 'react';
import { hashHistory } from 'react-router';

import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';
import Dialog from 'material-ui/Dialog';

import Icon from './Icon';

import Stub from './Stub';

export default React.createClass({
    propTypes: {
        editBaseUrl: React.PropTypes.string,
        entities: React.PropTypes.array,
    },

    getInitialState: function () {
        var entities = this.props.entities;

        return {
            entities: entities,
            showDialog: false,
            selectedEntity: null
        };
    },

    editEntity: function (entity) {
        hashHistory.push(this.props.editBaseUrl + entity.id);
    },

    confirmAndDeleteEntity: function (entity) {
        this.setState({ selectedEntity: entity });
        this.showDialog();
    },

    deleteEntity: function (entity) {
        // STUB
        this.setState({ entity: this.state.entities.filter(e => e.id != this.state.selectedEntity.id) });
        this.hideDialog();
    },

    showDialog: function () {
        this.setState({ showDialog: true });
    },

    hideDialog: function () {
        this.setState({ showDialog: false });
    },

    render: function () {
        var dialogActions = [
            <RaisedButton
                label="Cancel"
                primary={ true }
                onTouchTap={ this.hideDialog }
            />,
            <RaisedButton
                label="Delete"
                secondary={ true }
                onTouchTap={ this.deleteEntity }
            />,
        ];

        return (
            <div>
                <Dialog
                    actions={ dialogActions }
                    modal={ false }
                    open={ this.state.showDialog }
                    onRequestClose={ this.hideDialog }
                >
                    Are you sure you want to delete { this.state.entity ? this.state.entity.title : '<unknown>' }?
                </Dialog>

                { this.state.entities.map(entity =>
                    <Card className="question">
                        <CardTitle title={ entity.title } />

                        <CardText>{ entity.description }</CardText>

                        <CardActions>
                            <RaisedButton label="Edit" primary={ true } onClick={ () => this.editEntity(entity) } />
                            <RaisedButton label="Delete" secondary={ true } onClick={ () => this.confirmAndDeleteEntity(entity) } />
                        </CardActions>
                    </Card>
                ) }
            </div>
        );
    }
});