import React from 'react';

export default React.createClass({
    propTypes: {
        name: React.PropTypes.string.isRequired,
        light: React.PropTypes.boolean,
        size: React.PropTypes.number
    },

    getClassName: function () {
        var theme = (this.props.light && 'md-light') || '';
        var size = this.props.size || 'md-36';
        
        return `material-icons ${size} ${theme}`;
    },

    render: function () {
        return (
            <i className={ this.getClassName() }>{ this.props.name }</i>
        );
    }
});