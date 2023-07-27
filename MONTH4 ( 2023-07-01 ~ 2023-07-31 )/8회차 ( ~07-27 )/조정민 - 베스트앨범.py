class music:
        def __init__(self, index, play):
        self.index = index
        self.play = play

        def solution(genres, plays):
        answer = []
        dic = {}

        for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]

        if genre in dic:
        tmp = dic[genre]
        tmp['totalPlay'] += play
        tmp['musics'].append(music(i, play))

        else:
        dic[genre] = {'totalPlay' : play, 'musics' : [music(i, play)]}
        dic = sorted(dic.items(), key = lambda x : x[1]['totalPlay'], reverse=True)

        for i in dic:
        tmp = sorted(i[1]['musics'], key = lambda x : (-x.play, x.index))
        answer.append(tmp[0].index)

        if len(tmp) >= 2:
        answer.append(tmp[1].index)

        return answer
