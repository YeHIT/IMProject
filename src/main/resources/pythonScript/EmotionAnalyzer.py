import jiagu
import sys
def Analyzer(s):
    ls = []
    try:
        ls = jiagu.sentiment(s)
    except:
        ls = ['positive',0.5]
    if ls[0] == 'positive':
        result = ls[1]
    else:
        result = 0 - ls[1]
    return result
if __name__ == '__main__':
    result = Analyzer(str(sys.argv[1]))
    print(result)