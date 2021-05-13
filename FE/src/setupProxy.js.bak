const { createProxyMiddleware } = require('http-proxy-middleware');

// src/setupProxy.js
module.exports = function (app) {
    app.use(
        '/api',
        createProxyMiddleware({
            target: 'http://52.78.180.217',
            changeOrigin: true,
            onProxyReq(proxyReq, req, res) {
                proxyReq.setHeader('Origin', 'http://52.78.180.217');
            },
        }),
    );
};
