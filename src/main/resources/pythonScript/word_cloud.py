# -*- coding: utf-8 -*-
from wordcloud import WordCloud
import jieba
import jieba.posseg as pseg
import jieba.analyse
import sys
def genWC(context,imgpath,fontpath):
    positive_list = ('n','nr','nz','a','PER','ns','nt','LOC','ORG','nw')
    text = ""
    neg_text = ""
    keyword = []
    context = context.replace('null','')
    keyword = jieba.analyse.extract_tags(context, topK=10, withWeight=False, allowPOS=positive_list)
    if(len(keyword) == 0):
        keyword = jieba.analyse.extract_tags(context, topK=10, withWeight=False)
    if(len(keyword) == 0):
        keyword.append(context)
    for i in keyword:
        print(i)
    if(len(context) == 0):
        text = "生成词云失败请稍后尝试"
        print("无关键词")
    elif(len(context) <= 10):
        text = context
    else:
        ls = pseg.cut(context)
        for word,flag in ls:
            if flag in positive_list:
                text = text + ' ' + word
            else:
                neg_text = neg_text + ' ' + word
        #print('text:',text)
        #print('neg_text:',neg_text)
        if(len(text) == 0):
            text = neg_text
    wc = WordCloud(
                    background_color='white',
                    font_path=fontpath
                )
    try:
        wc.generate(text)
    except:
        wc.generate("生成词云失败请稍后尝试")
    wc.to_file(imgpath)


if __name__ == '__main__':
    genWC(str(sys.argv[1]),str(sys.argv[2]),str(sys.argv[3]))