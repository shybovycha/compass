import React from 'react';

export default React.createClass({
    propTypes: {
        name: React.PropTypes.string.isRequired,
        light: React.PropTypes.bool,
        size: React.PropTypes.number,
        onClick: React.PropTypes.func
    },

    getDefaultProps: function () {
        return {
            light: false,
            size: 36
        };
    },

    getClassName: function () {
        var theme = this.props.light ? 'md-light' : '';

        return `material-icons md-${this.props.size} ${theme}`;
    },

    render: function () {
        return (
            <i className={ this.getClassName() + this.props.className } onClick={ this.props.onClick }>{ this.props.name }</i>
        );
    }
});