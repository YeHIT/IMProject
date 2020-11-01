# -*- coding: utf-8 -*-
from wordcloud import WordCloud
import jieba
import jieba.posseg as pseg
import jieba.analyse
import sys
def genWC(context,imgpath,fontpath):
    positive_list = ('n','nr','nz','a','PER','ns','nt','LOC','ORG','nw')
    text = ""
    keyword = []
    if(len(context) == 0):
        text = "生成词云失败请稍后尝试"
        print("无关键词")
    else:
        keyword = jieba.analyse.extract_tags(context, topK=10, withWeight=False, allowPOS=positive_list)
        ls = pseg.cut(context)
        for i in keyword:
            print(i)
        for word,flag in ls:
            if flag in positive_list:
                text = text + ' ' + word
            else:
                pass
    wc = WordCloud(
        background_color='white',
        font_path=fontpath,
        )
    wc.generate(text)
    wc.to_file(imgpath)
    # return keyword


if __name__ == '__main__':
    genWC(str(sys.argv[1]),str(sys.argv[2]),str(sys.argv[3]))
