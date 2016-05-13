import React from 'react';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
// import {fullWhite} from 'material-ui/styles/colors';
// import FontIcon from 'material-ui/FontIcon';

export default React.createClass({
    propTypes: {
        title: React.PropTypes.string
    },

    render: function () {
        return (
            <div>
                <AppBar
                    title={this.props.title}
                    iconElementLeft={ <i className="material-icons md-36">menu</i> }
                />

                <div className="container">
                    <div className="row hide-on-med-and-up">
                        <div className="col s12 text-center">
                            <RaisedButton
                                icon={<i className="material-icons md-36">keyboard_arrow_up</i>}
                            />
                        </div>
                    </div>

                    <div className="row">
                        <div className="col s2 hide-on-small-only valign-wrapper">
                            <RaisedButton
                                icon={<i className="material-icons md-36 valign">keyboard_arrow_left</i>}
                            />
                        </div>
                          
                        <div className="col s8">{ this.props.children }</div>

                        <div className="col s2 hide-on-small-only valign-wrapper">
                            <RaisedButton
                                icon={<i className="material-icons md-36 valign">keyboard_arrow_right</i>}
                            />
                        </div>
                    </div>

                    <div className="row hide-on-med-and-up">
                        <div className="col s12 text-center">
                            <RaisedButton
                                icon={<i className="material-icons md-36">keyboard_arrow_down</i>}
                            />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
})
