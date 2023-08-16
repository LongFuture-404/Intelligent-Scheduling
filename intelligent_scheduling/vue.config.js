const defineConfig = require('@vue/cli-service').defineConfig;
const webpack = require("webpack");
const path = require('path');
const resolve = function (dir) {
  return path.join(__dirname, dir);
};
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = defineConfig({
  lintOnSave: false,
  transpileDependencies: true,
  publicPath: './',
  runtimeCompiler: true,
  devServer: {
    port: 8081,
    historyApiFallback: true,
    proxy: {
      '/api': {
        target: 'http://localhost:8080/',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
  },
  configureWebpack: function (config) {
    // 两种方式全局引入jquery
    //1.在vue create webpack的项目中使用
    // config.plugins = [
    //   new webpack.ProvidePlugin({
    //       $: 'jquery'
    //   }),
    //   new HtmlWebpackPlugin()
    // ]
    // config.extensions= ['.ts', '.js']
    //2.直接定义以哪种模式去加载所引入的额外的包
    // config.externals = {
    //   jquery:'jQuery'
    // };
    // 为生产环境修改配置...
    if (process.env.NODE_ENV === 'production') {
      config.mode = 'production';
      // 打包文件大小配置
      config.performance = {
        maxEntrypointSize: 10000000,
        maxAssetSize: 30000000
      };
    }
    else {
      config.plugins.push(new webpack.ProvidePlugin({
        $: 'jquery'
      }),new HtmlWebpackPlugin({filename:'webpack.html',
        template:'./public/index.html'}))
    }
  },
  chainWebpack: function (config) {
    config.resolve.alias
        .set('@', resolve('src'))
        .externals = { jquery: 'jQuery' }
        // @ts-ignore
        .plugins = [
      new webpack.ProvidePlugin({
        $: 'jquery'
      }),
      new HtmlWebpackPlugin()
    ];
  },
});
