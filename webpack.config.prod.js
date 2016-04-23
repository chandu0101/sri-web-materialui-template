'use strict';

var webpack = require('webpack'),
    CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin,
    _ = require('lodash');
var NODE_ENV = process.env.NODE_ENV;

module.exports = _.merge(require('./webpack.config.js'), {

    output: {
        publicPath: "assets/"
    },
    plugins: [
        new CommonsChunkPlugin({
            name: "mainpage"
        }),
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify('production'),
            }
        }),
        new webpack.optimize.OccurenceOrderPlugin(),
        new webpack.optimize.DedupePlugin(),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false,
                drop_console: true,
                hoist_vars: true,
                unsafe: true
            }
        })
    ]
});