import plotly.plotly as py
from plotly.grid_objs import Grid, Column

import time

column_1 = Column([1], 'x')
column_2 = Column([0.5], 'y')
column_3 = Column([1], 'x2')
column_4 = Column([500], 'y2')

grid = Grid([column_1, column_2, column_3, column_4])
py.grid_ops.upload(grid, 'merge-io_linear_simulation_1', auto_open=False)

figure = {
    'data': [
        {
            'xsrc': grid.get_column_reference('x'),
            'ysrc': grid.get_column_reference('y'),
            'mode': 'markers',
        }
    ],
    'layout': {'title': 'Simulation 1',
               'xaxis': {'range': [0, 2], 'autorange': False},
               'yaxis': {'range': [0, 500], 'autorange': False},
               'updatemenus': [{
                   'buttons': [
                       {'args': [None],
                        'label': 'Play',
                        'method': 'animate'}
               ],
               'pad': {'r': 10, 't': 87},
               'showactive': False,
               'type': 'buttons'
                }]},
    'frames': [
        {
            'data': [
                {
                    'xsrc': grid.get_column_reference('x2'),
                    'ysrc': grid.get_column_reference('y2'),
                    'mode': 'markers',
                }
            ]
        },
        {
            'data': [
                {
                    'xsrc': grid.get_column_reference('x'),
                    'ysrc': grid.get_column_reference('y'),
                    'mode': 'markers',
                }
            ]
        }
    ]
}

py.icreate_animations(figure, 'ping_pong'+str(time.time()))
