import React from 'react';

export default React.createClass({
    propTypes: {
        name: React.PropTypes.string.isRequired,
        light: React.PropTypes.bool,
        size: React.PropTypes.number
    },

    getDefaultProps: function () {
        return {
            light: false,
            size: 36
        };
    },

    getClassName: function () {
        var theme = (this.props.light && 'md-light') || '';
        
        return `material-icons md-${this.props.size} ${theme}`;
    },

    render: function () {
        return (
            <i className={ this.getClassName() }>{ this.props.name }</i>
        );
    }
});