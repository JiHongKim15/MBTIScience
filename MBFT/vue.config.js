module.exports = {  
    devServer: {  
      proxy: {
        '/':{
          target:  "http://localhost:8081",
          changeOrigin: true,
        }
      },
      historyApiFallback: true
    },  
    chainWebpack: config => {  
      const svgRule = config.module.rule("svg");    
      svgRule.uses.clear();    
      svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
    }  
  };